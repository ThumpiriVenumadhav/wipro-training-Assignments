import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MaterialModule } from '../../materialmodule';
import { MOVIES } from '../../data/movies';
import { Movie } from '../../models/movie.model';

@Component({
  selector: 'app-movie-list',
  imports: [CommonModule,MaterialModule],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css'
})
export class MovieListComponent {

   movies: Movie[] = MOVIES;
title: string = "Movie App"

  isTopRated(rating: number): boolean {
    return rating >= 4; // highlight movies rated 4 or 5
  }
}
