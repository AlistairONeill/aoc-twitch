package aoc.computer

class IntCodeComputer(private val program: List<Int>) {
    private var data = program.toTypedArray()
    private var index = 0

    private class STOP: Exception()

    fun run(noun: Int, verb: Int): Int {
        data = program.toTypedArray()
        index = 0
        data[1] = noun
        data[2] = verb
        try {
            while(true) {
                applyIntCode()
            }
        }
        catch(e: STOP) { }
        return data[0]
    }

    fun get(offset: Int) = data[index + offset]

    private val opCodes = mapOf(
        1 to TripleParamOperation { i, j, k -> data[k] = data[i] + data[j] },
        2 to TripleParamOperation { i, j, k -> data[k] = data[i] * data[j] },
        99 to NoParamOperation { throw STOP() }
    )

    private fun applyIntCode() {
        opCodes[get(0)]!!.run{
            perform()
            index += advance
        }
    }

    abstract inner class Operation {
        abstract fun perform()
        abstract val advance: Int
    }

    inner class NoParamOperation(
        private val function: () -> Unit
    ): Operation() {
        override fun perform() = function()
        override val advance = 1
    }

    inner class SingleParamOperation(
        private val function: (Int) -> Unit
    ): Operation() {
        override fun perform() = function(get(1))
        override val advance = 2
    }

    inner class DoubleParamOperation(
        private val function: (Int, Int) -> Unit
    ): Operation() {
        override fun perform() = function(get(1), get(2))
        override val advance = 3
    }

    inner class TripleParamOperation(
        private val function: (Int, Int, Int) -> Unit
    ): Operation() {
        override fun perform() = function(get(1), get(2), get(3))
        override val advance = 4
    }
}
