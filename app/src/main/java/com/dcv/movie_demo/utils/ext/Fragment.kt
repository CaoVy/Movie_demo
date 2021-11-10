package com.dcv.movie_demo.utils.ext

import androidx.fragment.app.Fragment

fun Fragment.addFragment(layout: Int, fragment: Fragment) {
    childFragmentManager.beginTransaction()
        .replace(layout, fragment)
        .addToBackStack(fragment::class.java.simpleName)
        .commit()
}
