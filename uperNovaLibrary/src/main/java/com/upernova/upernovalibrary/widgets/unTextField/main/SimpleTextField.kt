package com.upernova.upernovalibrary.widgets.unTextField.main

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upernova.upernovalibrary.widgets.unTextField.core.base.BaseTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.base.ListenerTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.model.InputModel
import com.upernova.upernovalibrary.widgets.unTextField.core.ui.BaseTextFieldComposeView
import com.upernova.upernovalibrary.widgets.unTextField.utils.getIconByStatus

class SimpleTextField<T>(
    override var textInputModel: InputModel<T>,
    override var modifier: Modifier,
) : BaseTextInput<T>() {

    @Composable
    override fun RenderView(listeners: ListenerTextInput<T>) {
        BaseTextFieldComposeView(
            inputModel = textInputModel,
            modifier = modifier,
            endIcon = getIconByStatus(textInputModel.textFieldStatus, textInputModel.typesIcons),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = textInputModel.properties.keyboardType,
                imeAction = textInputModel.properties.imeAction
            )
        ) {
            listeners.onAction(textInputModel.id, it)
        }
    }
}