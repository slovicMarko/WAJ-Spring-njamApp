import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RestoranService } from '../../services/restoran.service';
import { Restoran } from '../../models/restoran';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-otvoreni',
  standalone: false,
  templateUrl: './otvoreni.component.html',
  styleUrl: './otvoreni.component.css',
})
export class OtvoreniComponent implements OnInit {
  restorani: Observable<Restoran[]> = of([]);

  constructor(
    private route: ActivatedRoute,
    private restoranService: RestoranService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.restorani = this.restoranService.getOtvoreniSDostavom();
    console.log(this.restorani);
  }

  goBack(): void {
    this.location.back();
  }
}
