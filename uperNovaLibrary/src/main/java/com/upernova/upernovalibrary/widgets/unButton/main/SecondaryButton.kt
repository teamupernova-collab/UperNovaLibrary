package com.upernova.upernovalibrary.widgets.unButton.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upernova.upernovalibrary.widgets.unButton.core.base.ButtonType
import com.upernova.upernovalibrary.widgets.unButton.core.model.ButtonModel
import com.upernova.upernovalibrary.widgets.unButton.core.ui.BaseButtonComposeView

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