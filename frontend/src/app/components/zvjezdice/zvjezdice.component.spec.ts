import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZvjezdiceComponent } from './zvjezdice.component';

describe('ZvjezdiceComponent', () => {
  let component: ZvjezdiceComponent;
  let fixture: ComponentFixture<ZvjezdiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ZvjezdiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZvjezdiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
