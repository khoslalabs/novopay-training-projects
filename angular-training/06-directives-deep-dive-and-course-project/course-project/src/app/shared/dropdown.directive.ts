import { Directive, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appDropdown]'
})
export class DropdownDirective {

  @HostListener('document:click', ['$event']) toggleClass(event: Event) {
    this.elementRef.nativeElement.contains(event.target) ?
      this.elementRef.nativeElement.lastChild.classList.toggle('show') :
        this.renderer.removeClass(this.elementRef.nativeElement.lastChild, 'show');
  }

  constructor(private elementRef: ElementRef, private renderer: Renderer2) { }
}
