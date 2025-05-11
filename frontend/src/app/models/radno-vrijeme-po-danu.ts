import { RadnoVrijeme } from './radno-vrijeme';

export interface RadnoVrijemePoDanu {
  ponedjeljak: RadnoVrijeme | string | null;
  utorak: RadnoVrijeme | string | null;
  srijeda: RadnoVrijeme | string | null;
  cetvrtak: RadnoVrijeme | string | null;
  petak: RadnoVrijeme | string | null;
  subota: RadnoVrijeme | string | null;
  nedjelja: RadnoVrijeme | string | null;
}
