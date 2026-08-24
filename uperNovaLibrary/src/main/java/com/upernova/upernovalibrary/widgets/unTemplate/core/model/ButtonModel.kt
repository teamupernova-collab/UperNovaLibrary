package com.upernova.upernovalibrary.widgets.unTemplate.core.model

import com.upernova.upernovalibrary.widgets.unTemplate.core.base.ButtonStatus

data class ButtonModel(
    val buttonStatus: ButtonStatus = ButtonStatus.ENABLE,
    val buttonLabel: String = "",
)
