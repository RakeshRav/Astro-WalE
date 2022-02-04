package com.example.astro_wale.binding_adapter

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bindText")
fun bindHTMLText(
    view: TextView,
    text: String?,
) {
    text?.let {
        view.text = Html.fromHtml(text)
    } ?: run {
        view.text = ""
    }
}

@BindingAdapter("imageUrl")
fun imageUrl(
    imageView: ImageView,
    imageUrl: String?,
) {
    imageUrl?.let { url ->
        Glide.with(imageView).load(url).centerInside().into(imageView)
    }
}

@BindingAdapter("viewVisibility")
fun viewVisibility(
    view: View?,
    visible: Boolean?,
) {
    visible?.let {
        view?.visibility = if (it) View.VISIBLE else View.GONE
    }
}