import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restoran } from '../models/restoran';
import { RestoranCommand } from '../models/restoran-command';

@Injectable({
  providedIn: 'root',
})
export class RestoranService {
  private baseUrl = 'http://localhost:7000/restorani';

  constructor(private http: HttpClient) {}

  getRestorani(): Observable<Restoran[]> {
    return this.http.get<Restoran[]>(this.baseUrl);
  }

  getOtvoreniSDostavom(): Observable<Restoran[]> {
    return this.http.get<Restoran[]>(`${this.baseUrl}/otvoren-s-dostavom`);
  }

  getPretraziRestoranePoImenu(ime: string): Observable<Restoran[]> {
    return this.http.get<Restoran[]>(`${this.baseUrl}/pretraga?ime=${ime}`);
  }

  getRestoranById(id: number): Observable<Restoran | null> {
    return this.http.get<Restoran>(`${this.baseUrl}/${id}`);
  }

  dodajRestoran(restoran: RestoranCommand): Observable<string> {
    return this.http.post(`${this.baseUrl}/dodaj`, restoran, {
      responseType: 'text',
    });
  }

  getRestoraniPoZvjezdicama(zvjezdice: number): Observable<Restoran[]> {
    return this.http.get<Restoran[]>(
      `${this.baseUrl}/zvjezdice?number=${zvjezdice}`
    );
  }
}
