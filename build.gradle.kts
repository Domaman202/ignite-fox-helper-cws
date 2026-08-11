plugins {
  id("mod.base-conventions")
}

dependencies {
  paperweight.paperDevBundle(libs.versions.paper)

  compileOnly(libs.ignite)
  compileOnly(libs.mixin)
  compileOnly(libs.mixinExtras)

  annotationProcessor(libs.mixinExtras)

  compileOnly(files("libs/folia.jar"))
  compileOnly(files("libs/ignite.jar"))
  compileOnly(files("libs/FoX-CWS-1.0.0.jar"))
}
