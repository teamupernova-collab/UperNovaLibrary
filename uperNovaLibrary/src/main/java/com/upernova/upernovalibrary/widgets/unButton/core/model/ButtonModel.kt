package com.upernova.upernovalibrary.widgets.unButton.core.model

import com.upernova.upernovalibrary.widgets.unButton.core.base.ButtonStatus

data class ButtonModel(
    val buttonStatus: ButtonStatus = ButtonStatus.ENABLE,
    val buttonLabel: String = "",
)
