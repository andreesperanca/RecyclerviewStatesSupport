package com.andreesperanca.recyclerviewstatessupport

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.andreesperanca.recyclerviewstatessupport.databinding.CustomRecyclerViewEmptySupportBinding

class CustomRecyclerViewEmptySupport(
    context: Context,
    attrs: AttributeSet,
): ConstraintLayout(context, attrs) {

    /** INFLATE LAYOUT */
    private val binding =
        CustomRecyclerViewEmptySupportBinding
            .inflate(LayoutInflater.from(context),
            this,
            true)

    /**UI COMPONENTS*/
    lateinit var progressView: FrameLayout
    lateinit var rv: RecyclerView
    lateinit var emptyView: LinearLayoutCompat

    /** */
    var rState: RecyclerStates = RecyclerStates.Loading()

    init {
        initComponents()
        setupRecyclerView()
    }

    /** HELPER  CLASS */
    var adapter = null
    var layoutManager = null

    fun updateState() {
        when (this.rState) {
            is RecyclerStates.Empty -> {
                disableAllComponents()
                emptyView.visibility = View.VISIBLE
            }
            is RecyclerStates.Loading -> {
                disableAllComponents()
                progressView.visibility = View.VISIBLE
            }
            is RecyclerStates.Success -> {
                disableAllComponents()
                rv.visibility = View.VISIBLE
            }
        }
    }

    private fun disableAllComponents() {
        emptyView.visibility = View.INVISIBLE
        progressView.visibility = View.INVISIBLE
        rv.visibility = View.INVISIBLE
    }

    private fun initComponents() {
        progressView = binding.progressView
        rv = binding.recyclerView
        emptyView = binding.emptyView
    }

    private fun setupRecyclerView() {
        rv.adapter = adapter
        rv.layoutManager = layoutManager
    }
}
