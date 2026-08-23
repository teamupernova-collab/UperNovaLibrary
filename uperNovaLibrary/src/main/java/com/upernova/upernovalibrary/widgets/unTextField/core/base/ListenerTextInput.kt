package com.upernova.upernovalibrary.widgets.unTextField.core.base


interface ListenerTextInput<T> {
    fun onAction(inputId: T, inputActions: ActionsListeners)
}