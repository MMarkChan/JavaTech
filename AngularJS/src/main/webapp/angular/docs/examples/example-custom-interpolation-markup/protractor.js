it('should interpolate binding with custom symbols', function() {
  expect(element(by.binding('basic.label')).getText()).toBe('This binding is brought you by // interpolation symbols.');
});