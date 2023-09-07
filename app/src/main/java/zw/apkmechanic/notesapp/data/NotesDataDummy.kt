package zw.apkmechanic.notesapp.data

import zw.apkmechanic.notesapp.models.Note


class NotesDataDummy {

    fun getAllNotes(): List<Note>{
        return listOf(
            Note(title = "title 1", desc = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, odit architecto repellat voluptatum aliquam perferendis iure porro aliquid aspernatur nulla!"),
            Note(title = "title 2", desc = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, odit architecto repellat voluptatum aliquam perferendis iure porro aliquid aspernatur nulla!"),
            Note(title = "title 3", desc = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, odit architecto repellat voluptatum aliquam perferendis iure porro aliquid aspernatur nulla!"),
            Note(title = "title 4", desc = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, odit architecto repellat voluptatum aliquam perferendis iure porro aliquid aspernatur nulla!"),
            Note(title = "title 5", desc = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, odit architecto repellat voluptatum aliquam perferendis iure porro aliquid aspernatur nulla!"),
        )
    }
}