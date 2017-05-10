package au.com.gridstone.training_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

class MainActivity : AppCompatActivity() {
  private lateinit var router: Router

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val container = findViewById(R.id.main_container) as ViewGroup
    router = Conductor.attachRouter(this, container, savedInstanceState)

    if (!router.hasRootController()) router.setRoot(RouterTransaction.with(HomeController()))
  }

  override fun onBackPressed() {
    if (!router.handleBack()) super.onBackPressed()
  }
}
