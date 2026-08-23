package com.upernova.upernovalibrary.widgets.unTextField.main

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.example.textinputkitlibrary.utils.ui.PasswordTransformation
import com.upernova.upernovalibrary.R
import com.upernova.upernovalibrary.widgets.unTextField.core.base.ActionsListeners
import com.upernova.upernovalibrary.widgets.unTextField.core.base.BaseTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.base.ListenerTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.model.InputModel
import com.upernova.upernovalibrary.widgets.unTextField.core.ui.BaseTextFieldComposeView

class PasswordTextField<T>(
    override var textInputModel: InputModel<T>,
    override var modifier: Modifier
) : BaseTextInput<T>() {


    @Composable
    override fun RenderView(listeners: ListenerTextInput<T>) {
        var showPass by rememberSaveable { mutableStateOf(false) }

        BaseTextFieldComposeView(
            inputModel = textInputModel,
            modifier = modifier,
            endIcon  = if (!showPass) R.drawable.eye_visible_icon else R.drawable.eye_invisible_icon,
            visualTransformation = if (showPass) VisualTransformation.None else PasswordTransformation(),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = textInputModel.properties.keyboardType,
                imeAction = textInputModel.properties.imeAction
            )
        ) {
            when (it) {
                is ActionsListeners.OnValueChange -> {
                    if (it.text.text.all { it in textInputModel.properties.keyBoardPasswordPermit })
                        listeners.onAction(textInputModel.id, inputActions = it)
                }
                ActionsListeners.OnEndIconAction -> {
                    showPass = !showPass
                }
                is ActionsListeners.OnFocusChange,
                is ActionsListeners.OnKeyBoardAction -> listeners.onAction(
                    textInputModel.id,
                    inputActions = it
                )
            }
        }
    }
}