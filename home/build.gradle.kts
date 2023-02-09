plugins {
    id(Plugins.androidLibrary)
    kotlin(KotlinPlugins.android)
    id(KotlinPlugins.jetpack_navigation_plugin)
}

android {
    namespace = Application.appId

    compileSdk = Application.compileSdk
    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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


    //JETPACK-NAVIGATION
    implementation(Navigation.navigation_fragments)
    implementation(Navigation.navigation_kotlin_ui)


    //TEST LIBS
    testImplementation(GeneralTest.junit)
    androidTestImplementation(GeneralTest.ext_junit)
    androidTestImplementation(GeneralTest.espresso_core)

    //CORE-UI
    implementation(project(":core:ui"))
}