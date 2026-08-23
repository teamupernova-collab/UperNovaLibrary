package com.upernova.upernovalibrary.widgets.unTextField.core.base


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.upernova.upernovalibrary.widgets.unTextField.core.model.InputModel
import org.jetbrains.annotations.ApiStatus.Internal

@Internal
abstract class BaseTextInput<T> {
    abstract var textInputModel: InputModel<T>
    abstract var modifier: Modifier

    @Composable
    abstract fun RenderView(listeners: ListenerTextInput<T>)
}