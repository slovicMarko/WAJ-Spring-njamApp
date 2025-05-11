import { Component, OnInit } from '@angular/core';
import { Restoran } from '../../models/restoran';
import { RestoranService } from '../../services/restoran.service';
import { RestoranDtoService } from '../../services/restoran-dto.service';
import { RestoranDTO } from '../../models/restoran-dto';
import { Observable } from 'rxjs';
import { RestoranCommand } from '../../models/restoran-command';
import { RadnoVrijemePoDanu } from '../../models/radno-vrijeme-po-danu';
import { RadnoVrijeme } from '../../models/radno-vrijeme';

@Component({
  standalone: false,
  selector: 'app-restoran-list',
  templateUrl: './restoran-list.component.html',
  styleUrls: ['./restoran-list.component.css'],
})
export class RestoranListComponent implements OnInit {
  dani = [
    { label: 'Ponedjeljak', name: 'ponedjeljak' },
    { label: 'Utorak', name: 'utorak' },
    { label: 'Srijeda', name: 'srijeda' },
    { label: 'Četvrtak', name: 'cetvrtak' },
    { label: 'Petak', name: 'petak' },
    { label: 'Subota', name: 'subota' },
    { label: 'Nedjelja', name: 'nedjelja' },
  ];

  restorani: Restoran[] = [];
  filtriraniRestorani: Restoran[] = [];
  odabraniRestoran: Restoran | null = null;
  odabraniRestoranDTO: RestoranDTO | null = null;
  sortAsc: boolean = true;
  filterTekst: string = '';
  noviRestoran: RestoranCommand = {
    ime: '',
    adresa: '',
    brojTelefona: '',
    email: '',
    trenutnoOtvoren: false,
    kratakOpis: '',
    radnoVrijeme: {
      ponedjeljak: null,
      utorak: null,
      srijeda: null,
      cetvrtak: null,
      petak: null,
      subota: null,
      nedjelja: null,
    } as RadnoVrijemePoDanu,
    webStranica: '',
    vlastitaDostava: false,
  };

  radnoVrijemeOptions: string[] = Object.values(RadnoVrijeme);

  // Privremene varijable za svaki dan
  privremenoRadnoVrijeme: { [key: string]: RadnoVrijeme } = {};

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

  odaberi(restoran: Restoran): void {
    if (restoran.zvjezdica >= 3) {
      const dto = this.restoranDtoService.getRestoranDtoById(restoran.id);
      if (dto instanceof Observable) {
        dto.subscribe((result) => {
          this.odabraniRestoranDTO = result || null;
          this.odabraniRestoran = null;
        });
      } else {
        this.odabraniRestoranDTO = dto || null;
        this.odabraniRestoran = null;
      }
    } else {
      this.odabraniRestoran = restoran;
      this.odabraniRestoranDTO = null;
    }
  }

  dodajRestoran(): void {
    this.restoranService.dodajRestoran(this.noviRestoran).subscribe({
      next: (poruka) => {
        alert(poruka);
        this.ucitajRestorane();
        this.noviRestoran = {
          ime: '',
          adresa: '',
          brojTelefona: '',
          email: '',
          trenutnoOtvoren: false,
          kratakOpis: '',
          radnoVrijeme: {
            ponedjeljak: null,
            utorak: null,
            srijeda: null,
            cetvrtak: null,
            petak: null,
            subota: null,
            nedjelja: null,
          } as RadnoVrijemePoDanu,
          webStranica: '',
          vlastitaDostava: false,
        };
      },
      error: (err) => {
        alert('Greška pri dodavanju restorana!');
        console.error(err);
      },
    });
  }

  azurirajRadnoVrijeme(dan: string, vrijednost: string) {
    const key = getRadnoVrijemeKey(vrijednost);
    if (this.noviRestoran.radnoVrijeme) {
      const validnoRadnoVrijeme = Object.values(RadnoVrijeme).includes(
        vrijednost as RadnoVrijeme
      )
        ? (vrijednost as RadnoVrijeme)
        : null;

      this.noviRestoran.radnoVrijeme[dan as keyof RadnoVrijemePoDanu] =
        key ?? null;
    }
  }
}

function getRadnoVrijemeKey(
  value: string
): keyof typeof RadnoVrijeme | undefined {
  return Object.keys(RadnoVrijeme).find(
    (key) => RadnoVrijeme[key as keyof typeof RadnoVrijeme] === value
  ) as keyof typeof RadnoVrijeme | undefined;
}
