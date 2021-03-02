import { Directive, ElementRef, HostBinding, HostListener, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective  implements OnInit {
  @Input() defaultColor: string = 'transparent';
  @Input('appBetterHighlight') higlightColor: string = 'orange';

  @HostBinding('style.backgroundColor') bgColor: string;

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  ngOnInit() {
    // this.renderer.setStyle(this.elRef.nativeElement, 'backgroundColor', 'orange');
    this.bgColor = this.defaultColor;
  }

  @HostListener('mouseenter') mouseOver() {
    // this.renderer.setStyle(this.elRef.nativeElement, 'backgroundColor', 'orange');
    this.bgColor = this.higlightColor;
  }
  
  @HostListener('mouseleave') mouseLeave() {
    // this.renderer.setStyle(this.elRef.nativeElement, 'backgroundColor', 'transparent');
    this.bgColor = this.defaultColor;
  }
}
