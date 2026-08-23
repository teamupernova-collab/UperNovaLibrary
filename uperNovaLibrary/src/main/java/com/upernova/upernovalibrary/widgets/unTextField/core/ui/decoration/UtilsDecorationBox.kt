package com.example.textinputkitlibrary.core.uitextfield.decoration

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.textinputkitlibrary.utils.ui.CharcoalGray
import com.example.textinputkitlibrary.utils.ui.ErrorRed
import com.example.textinputkitlibrary.utils.ui.SuccessGreen
import com.example.textinputkitlibrary.utils.ui.WarningAmber
import com.example.textinputkitlibrary.utils.ui.gray500ColorBox
import com.upernova.upernovalibrary.widgets.unTextField.core.base.TextFieldStatus
import org.jetbrains.annotations.ApiStatus.Internal


@Internal
fun getUnderLineBox(focusState: Boolean, textFieldStatus: TextFieldStatus): Color {
    return when (focusState) {
        true -> {
            when (textFieldStatus) {
                TextFieldStatus.ERROR -> ErrorRed
                TextFieldStatus.SUCCESS -> SuccessGreen
                TextFieldStatus.WARNING -> WarningAmber
                else -> CharcoalGray
            }
        }

        false -> {
            when (textFieldStatus) {
                TextFieldStatus.ERROR -> ErrorRed
                TextFieldStatus.SUCCESS -> SuccessGreen
                TextFieldStatus.WARNING -> WarningAmber
                TextFieldStatus.DISABLE -> gray500ColorBox
                else -> CharcoalGray
            }
        }
    }
}


@Internal
fun getUnderLineHeightBox(
    focusState: Boolean,
    value: String,
): Dp {
    return when (focusState) {
        true -> {
            Dp(1.0F)
        }

        false -> {
            if (value.isNotEmpty()) {
                Dp(1.0F)
            } else {
                Dp(0.5F)
            }
        }
    }
}