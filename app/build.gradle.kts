import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.example.walletobserver"
        minSdkVersion(19)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                    getDefaultProguardFile(
                            "proguard-android-optimize.txt"
                    ),
                    "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    applicationVariants.all(object : Action<ApplicationVariant> {
        override fun execute(variant: ApplicationVariant) {
            variant.outputs.all(object : Action<BaseVariantOutput> {
                override fun execute(output: BaseVariantOutput) {
                    val outputImpl = output as BaseVariantOutputImpl
                    val fileName = output.outputFileName
                        .replace(
                            "-release",
                            "-release-v${defaultConfig.versionName}-vc${defaultConfig.versionCode}"
                        )
                        .replace(
                            "-debug",
                            "-debug-v${defaultConfig.versionName}-vc${defaultConfig.versionCode}"
                        )
                    outputImpl.outputFileName = fileName
                }
            })
        }
    })

    androidExtensions {
        isExperimental = true
    }

    buildToolsVersion = "28.0.3"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.31")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1")

    implementation("androidx.navigation:navigation-fragment-ktx:2.1.0-alpha05")
    implementation("androidx.navigation:navigation-ui-ktx:2.1.0-alpha05")

    implementation("androidx.appcompat:appcompat:1.1.0-beta01")
    implementation("androidx.core:core-ktx:1.2.0-alpha02")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta1")
//    implementation("androidx.paging:paging-runtime-ktx:2.1.0")

//    implementation("com.google.code.gson:gson:2.8.5")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0-alpha01")

    implementation("com.google.android.material:material:1.1.0-alpha07")

//    implementation("com.squareup.retrofit2:retrofit:2.6.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.5.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:3.12.1")

    implementation("com.jakewharton.timber:timber:4.7.1")

    implementation("org.koin:koin-core:2.0.1")
    implementation("org.koin:koin-core-ext:2.0.1")
    implementation("org.koin:koin-android:2.0.1")
    implementation("org.koin:koin-android-scope:2.0.1")
    implementation("org.koin:koin-android-viewmodel:2.0.1")

    testImplementation("junit:junit:4.13-beta-3")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}