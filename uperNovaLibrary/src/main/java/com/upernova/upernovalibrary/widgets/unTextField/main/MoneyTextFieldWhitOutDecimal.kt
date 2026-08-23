package com.upernova.upernovalibrary.widgets.unTextField.main

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.upernova.upernovalibrary.widgets.unTextField.core.base.ActionsListeners
import com.upernova.upernovalibrary.widgets.unTextField.core.base.BaseTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.base.ListenerTextInput
import com.upernova.upernovalibrary.widgets.unTextField.core.model.InputModel
import com.upernova.upernovalibrary.widgets.unTextField.core.ui.BaseTextFieldComposeView
import com.upernova.upernovalibrary.widgets.unTextField.utils.formatMoney
import com.upernova.upernovalibrary.widgets.unTextField.utils.getIconByStatus
import com.upernova.upernovalibrary.widgets.unTextField.utils.keyboardMoneyPermit

class MoneyTextFieldWhitOutDecimal<T>(
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
            when (it) {
                is ActionsListeners.OnValueChange -> {
                    if (it.text.text.all { it in keyboardMoneyPermit }) {
                        var formattedText = it.text.text.replace("$", "").replace(",", "")
                        formattedText = formattedText.ifEmpty { "0" }
                        val newValueMoney = formattedText.toDouble().formatMoney()
                        if (formattedText.length in 0..textInputModel.properties.maxLength) {
                            listeners.onAction(
                                inputId = textInputModel.id,
                                inputActions = ActionsListeners.OnValueChange(
                                    TextFieldValue(
                                        text = newValueMoney,
                                        selection = TextRange(newValueMoney.length)
                                    )
                                )
                            )
                        }
                    }
                }

                ActionsListeners.OnEndIconAction,
                is ActionsListeners.OnFocusChange,
                is ActionsListeners.OnKeyBoardAction,
                    -> listeners.onAction(
                    textInputModel.id,
                    it
                )
            }
        }
    }
}