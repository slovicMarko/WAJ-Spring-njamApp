import { RadnoVrijemePoDanu } from './radno-vrijeme-po-danu';

export interface RestoranCommand {
  ime: string;
  adresa: string;
  brojTelefona: string;
  email: string;
  radnoVrijeme?: RadnoVrijemePoDanu;
  trenutnoOtvoren: boolean;
  prosjecnoVrijemeDostave?: number;
  prosjecnaOcjena?: number;
  maksimalanBrojNarudzbi?: number;
  michelinStar?: number;
  kratakOpis: string;
  webStranica: string;
  vlastitaDostava: boolean;
}
