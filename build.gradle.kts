plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.todolist"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.todolist"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}


    dependencies {
        implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
        implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")

        implementation("androidx.room:room-runtime:2.6.1")
        annotationProcessor("androidx.room:room-compiler:2.6.1")

        implementation("androidx.recyclerview:recyclerview:1.3.2")
    }
