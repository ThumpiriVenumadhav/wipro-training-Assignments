import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { SONGS } from '../../data/songs';
import { Song } from '../../models/song.model';
import { MaterialModule } from '../../materialmodule';

@Component({
  selector: 'app-song-list',
  imports: [CommonModule,MaterialModule],
  templateUrl: './song-list.component.html',
  styleUrl: './song-list.component.css'
})
export class SongListComponent {

   songs: Song[] = SONGS;

  playSong(song: Song) {
    alert(`Play button clicked for: ${song.title} 🎶`);
  }

}
