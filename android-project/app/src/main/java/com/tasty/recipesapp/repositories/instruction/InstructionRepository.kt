package com.tasty.recipesapp.repositories.instruction

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.data.dtos.InstructionDTO
import com.tasty.recipesapp.data.dtos.toModel
import com.tasty.recipesapp.repositories.IGenericRepository
import org.json.JSONObject
import java.io.IOException

class InstructionsRepository : IGenericRepository<InstructionModel> {

    override fun getAll(context: Context): List<InstructionModel> {
        return readAll(context).toInstructionModelList()
    }

    private fun readAll(context : Context): List<InstructionDTO> {
        val gson = Gson()
        var instructionList = listOf<InstructionDTO>()
        val assetManager = context.assets
        try {
            val inputStream = assetManager.open("instructions.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            val jsonObject = JSONObject(jsonString)
            val instructionsArray = jsonObject.getJSONArray("instructions")

            val type = object : TypeToken<List<InstructionDTO>>() {}.type
            instructionList = gson.fromJson(instructionsArray.toString(), type)


            Log.i("GSON", instructionList.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return instructionList
    }
    fun List<InstructionDTO>.toInstructionModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }


}
