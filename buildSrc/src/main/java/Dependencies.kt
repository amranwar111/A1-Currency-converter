import Versions.javaxAnnotationVersion
import Versions.javaxInjectVersion

object Dependencies {

    const val coroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.version_kotlin_coroutines}"
    const val coroutine_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.version_kotlin_coroutines}"
    const val coroutine_adapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.version_retrofit_coroutines_adapter}"


    const val javaxAnnotation = "javax.annotation:jsr250-api:${javaxAnnotationVersion}"
    const val javaxInject = "javax.inject:javax.inject:${javaxInjectVersion}"

    const val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_components}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_components}"


    const val material_dialogs = "com.afollestad.material-dialogs:core:${Versions.material_dialogs}"
    const val material_dialogs_input =
        "com.afollestad.material-dialogs:input:${Versions.material_dialogs}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val datastore = "androidx.datastore:datastore-core:${Versions.datastore}"
    const val datastore_preference =
        "androidx.datastore:datastore-preferences:${Versions.datastore}"
    const val play_core = "com.google.android.play:core:${Versions.play_core}"

    const val lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle_version}"
    const val lifecycle_coroutines =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    const val moshi_converter =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2_version}"
    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"
    const val logging_interceptor =
        "com.github.ihsanbal:LoggingInterceptor:${Versions.logging_interceptor}"

    const val json_org = "org.json:json:20180813"
    const val gson = "com.google.code.gson:gson:2.8.7"
}
