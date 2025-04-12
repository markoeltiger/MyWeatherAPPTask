    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.android)
        alias(libs.plugins.kotlin.compose)
        alias(libs.plugins.hilt)
        id("kotlin-kapt")
    }

    android {
        namespace = "com.mark.myweatherapptask"
        compileSdk = 35

        defaultConfig {
            applicationId = "com.mark.myweatherapptask"
            minSdk = 24
            targetSdk = 35
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            buildConfigField("String", "API_KEY", "${findProperty("API_KEY")}")

        }
        packaging {
            resources {
                excludes += "META-INF/LICENSE.md"
                excludes += "META-INF/LICENSE-notice.md" // Add more if needed
            }
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
        kotlinOptions {
            jvmTarget = "11"
        }
        buildFeatures {
            buildConfig = true
            compose = true
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
        // Core
        implementation(libs.kotlin.stdlib)
        implementation(libs.coroutines.android)

        // Compose
        implementation(libs.compose.ui)
        implementation(libs.compose.material3)
        implementation(libs.compose.runtime)
        implementation(libs.compose.ui.tooling.preview)
        implementation(libs.compose.constraintlayout)

        // Lifecycle + Navigation
        implementation(libs.lifecycle.viewmodel.compose)
        implementation(libs.lifecycle.runtime.compose)
        implementation(libs.navigation.compose)

        // Hilt
        implementation(libs.hilt)
        implementation(libs.hilt.navigation.compose)
        kapt(libs.hilt.compiler)

        // Timber (Logging)
        implementation(libs.timber)
        //features
        implementation(project(":domain"))
        implementation(project(":core"))
        implementation(project(":features:homefeature"))
        implementation(project(":features:currentweather"))
        implementation(project(":features:forcastfeature"))

        // Testing
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.espresso.core)
        //retrofit
        implementation(libs.retrofit)
        implementation(libs.retrofit.gson)
        implementation(libs.okhttp)
        implementation(libs.okhttp.logging)
    }