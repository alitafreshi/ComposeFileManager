plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
}


android {
    namespace = Application.appId

    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        multiDexEnabled = true
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        //signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compose_compiler_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //ANDROIDX
    implementation(AndroidX.kotlin_core_ktx)
    implementation(AndroidX.lifecycle_runtime)

    //COMPOSE
    implementation(platform(Compose.composeBoom))

    androidTestImplementation(Compose.composeBoom)

    implementation(Compose.compose_activity)
    implementation(Compose.compose_material_2)
    implementation(Compose.compose_preview)
    implementation(Compose.compose_ui_tooling)
    implementation(Compose.compose_compiler)
    implementation(Compose.compose_constraint_layout)
    implementation(Compose.compose_viewModel)

    //COMPOSE CHART
    implementation(Chart.compose_chart)


    //COMPOSE-TEST
    androidTestImplementation(ComposeTest.compose_junit)
    debugImplementation(ComposeTest.compose_manifest_ui)

    //TEST LIBS
    testImplementation(GeneralTest.junit)
    androidTestImplementation(GeneralTest.ext_junit)
    androidTestImplementation(GeneralTest.espresso_core)
}