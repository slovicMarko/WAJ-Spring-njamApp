import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule, Location } from '@angular/common';
import { RestoranService } from '../../services/restoran.service';
import { Restoran } from '../../models/restoran';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-restoran-detalji',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './restoran-detalji.component.html',
  styleUrl: './restoran-detalji.component.css',
})
export class RestoranDetaljiComponent implements OnInit {
  restoran!: Observable<Restoran | null>;

  constructor(
    private route: ActivatedRoute,
    private restoranService: RestoranService,
    private location: Location
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.restoran = this.restoranService.getRestoranById(id);
    }
  }

  goBack(): void {
    this.location.back();
  }
}
