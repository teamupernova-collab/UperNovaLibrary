package com.upernova.upernovalibrary.widgets.unTextField.core.model

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.upernova.upernovalibrary.widgets.unTextField.core.base.TextFieldStatus

data class InputModel<T>(
    val id: T,
    val textFieldStatus: TextFieldStatus = TextFieldStatus.ENABLE,
    val textValue: TextFieldValue,
    val typesIcons: TypesIcons = TypesIcons(),
    val helperText: String = "",
    val properties: InputProperties = InputProperties()
)

data class InputProperties(
    val maxLength: Int = 0,
    val keyBoardPasswordPermit: String = "",
    val keyboardType: KeyboardType = KeyboardType.Text,
    val imeAction: ImeAction = ImeAction.Done,
    val countLength:Boolean = false,
)

data class TypesIcons(
    val startIcon: Any? = null,
    val endIcon: Int? = null,
    val successIcon: Int? = null,
    val errorIcon: Int? = null,
    val warning: Int? = null,
)