package com.andreesperanca.recyclerviewstatessupport


sealed class RecyclerStates() {
    class Success() : RecyclerStates()
    class Loading() : RecyclerStates()
    class Empty() : RecyclerStates()
}
