import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { RestoranDTO } from '../models/restoran-dto';

@Injectable({
  providedIn: 'root',
})
export class RestoranDtoService {
  private restoraniDTO: RestoranDTO[] = [
    {
      id: 1,
      ime: 'Bistro Plavi Val',
      adresa: 'Obala kralja Tomislava 12, Split',
      trenutnoOtvoren: true,
      opterecenost: 35,
      ocjena: 4.3,
      brojTelefona: '+385 21 456 789',
      opis: 'Restoran uz more poznat po svježoj ribi i domaćoj pašticadi.',
      zvjezdica: 4,
    },
    {
      id: 2,
      ime: 'Zeleni Vrt',
      adresa: 'Park šuma Maksimir 8, Zagreb',
      trenutnoOtvoren: false,
      opterecenost: 0,
      ocjena: 4.7,
      brojTelefona: '+385 1 234 5678',
      opis: 'Mirno mjesto u prirodi s velikim izborom vegetarijanskih jela.',
      zvjezdica: 5,
    },
    {
      id: 3,
      ime: 'Grill Kod Joze',
      adresa: 'Ulica Ivana Gundulića 14, Osijek',
      trenutnoOtvoren: true,
      opterecenost: 60,
      ocjena: 4.1,
      brojTelefona: '+385 31 654 321',
      opis: 'Popularni grill s roštiljem na drveni ugljen i velikim porcijama.',
      zvjezdica: 3,
    },
    {
      id: 4,
      ime: 'Pasta & Basta',
      adresa: 'Masarykova 5, Rijeka',
      trenutnoOtvoren: true,
      opterecenost: 50,
      ocjena: 4.6,
      brojTelefona: '+385 51 789 123',
      opis: 'Talijanski restoran s domaćom tjesteninom i raznovrsnim umacima.',
      zvjezdica: 4,
    },
    {
      id: 5,
      ime: 'Slatki Užitak',
      adresa: 'Trg bana Jelačića 1, Varaždin',
      trenutnoOtvoren: false,
      opterecenost: 0,
      ocjena: 4.8,
      brojTelefona: '+385 42 321 987',
      opis: 'Slastičarnica s ručno rađenim kolačima i vrhunskom kavom.',
      zvjezdica: 5,
    },
  ];

  constructor() {}

  getRestorani(): Observable<RestoranDTO[]> {
    return of(this.restoraniDTO);
  }

  getRestoranDtoById(id: number): RestoranDTO | undefined {
    return this.restoraniDTO.find((restoran) => restoran.id === id);
  }
}
