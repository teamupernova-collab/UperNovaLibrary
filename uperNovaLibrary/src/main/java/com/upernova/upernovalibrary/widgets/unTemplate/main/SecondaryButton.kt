package com.upernova.upernovalibrary.widgets.unTemplate.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upernova.upernovalibrary.widgets.unTemplate.core.base.ButtonType
import com.upernova.upernovalibrary.widgets.unTemplate.core.model.ButtonModel
import com.upernova.upernovalibrary.widgets.unTemplate.core.ui.BaseButtonComposeView

@Composable
fun SecondaryButton(
    buttonModel: ButtonModel,
    modifier: Modifier,
    onClickListener: () -> Unit,
) {
    BaseButtonComposeView(buttonModel, modifier, ButtonType.SECONDARY) {
        onClickListener()
    }
}