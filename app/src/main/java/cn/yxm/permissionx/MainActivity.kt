package cn.yxm.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import cn.permission.yxm.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btn_call).setOnClickListener {

            PermissionX.request(this, Manifest.permission.CALL_PHONE) { allGranted, _ ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "请开启相关权限", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}