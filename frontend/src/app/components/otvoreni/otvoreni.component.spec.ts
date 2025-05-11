import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OtvoreniComponent } from './otvoreni.component';

describe('OtvoreniComponent', () => {
  let component: OtvoreniComponent;
  let fixture: ComponentFixture<OtvoreniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OtvoreniComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OtvoreniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
