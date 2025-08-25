import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MovieListComponent } from "./components/movie-list/movie-list.component";
import { MatToolbar } from "@angular/material/toolbar";
import { SongListComponent } from "./components/song-list/song-list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MovieListComponent, MatToolbar, SongListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'movielistapp';
}
