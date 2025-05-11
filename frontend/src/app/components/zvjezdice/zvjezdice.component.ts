import { Component, OnInit } from '@angular/core';
import { Restoran } from '../../models/restoran';
import { RestoranService } from '../../services/restoran.service';
import { RestoranDtoService } from '../../services/restoran-dto.service';

@Component({
  selector: 'app-zvjezdice',
  standalone: false,
  templateUrl: './zvjezdice.component.html',
  styleUrl: './zvjezdice.component.css',
})
export class ZvjezdiceComponent implements OnInit {
  restorani: Restoran[] = [];
  filtriraniRestorani: Restoran[] = [];
  filterTekst: string = '';

  constructor(
    private restoranService: RestoranService,
    private restoranDtoService: RestoranDtoService
  ) {}

  ngOnInit(): void {
    this.ucitajRestorane();
  }

  ucitajRestorane(): void {
    this.restoranService.getRestorani().subscribe((data) => {
      this.restorani = data;
      this.filtriraniRestorani = data;
    });
  }

  filtrirajPoZvjezdicama(): void {
    const broj = Number(this.filterTekst);
    if (!isNaN(broj)) {
      this.restoranService.getRestoraniPoZvjezdicama(broj).subscribe((data) => {
        this.filtriraniRestorani = data;
      });
    }
  }
}
