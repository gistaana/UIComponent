package com.example.uicomponents

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_take_picture -> Toast.makeText(this, "you clicked the take picture option", Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://temple.edu")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Delete confirmation")
                    .setMessage("Are you sure you want to delete this picture?")
                    .setPositiveButton("Yes") {_,_ -> Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("No") {dialog,_ -> dialog.cancel()}
                    .setCancelable(false)
                    .create()
                    .show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}