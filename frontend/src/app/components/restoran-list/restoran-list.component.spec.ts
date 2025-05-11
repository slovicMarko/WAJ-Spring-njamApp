import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestoranListComponent } from './restoran-list.component';

describe('RestoranListComponent', () => {
  let component: RestoranListComponent;
  let fixture: ComponentFixture<RestoranListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RestoranListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestoranListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
