package com.example.apptolearn.aboutdev

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class DevInfo (
    @DrawableRes val profileImage: Int,
    @DrawableRes val headerImage: Int,
    @StringRes val name: Int,
    @StringRes val bio: Int
)