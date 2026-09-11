package com.upernova.upernovalibrary.widgets.unButton.core.model

import androidx.annotation.DrawableRes
import com.upernova.upernovalibrary.widgets.unButton.core.base.ButtonStatus

data class ButtonModel(
    val buttonStatus: ButtonStatus = ButtonStatus.ENABLE,
    val buttonLabel: String = "",
    @param:DrawableRes val buttonIcon: Int? = null
)
