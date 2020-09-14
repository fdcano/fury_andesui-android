package com.mercadolibre.android.andesui.coachmark.model
import android.support.v4.widget.NestedScrollView
import android.view.View
import java.io.Serializable

data class AndesWalkthroughCoachmark(
    val steps: MutableList<AndesWalkthroughCoachmarkStep>,
    val scrollView: NestedScrollView,
    val completionHandler: () -> Unit
) : Serializable

data class AndesWalkthroughCoachmarkStep(
    val title: String,
    val description: String,
    val nextText: String,
    val highlightedView: View?,
    val style: String
) : Serializable