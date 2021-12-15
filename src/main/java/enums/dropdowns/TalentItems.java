package enums.dropdowns;

/**
 * 'Talent' dropdown items
 *
 */
public enum TalentItems {
  DISCOVER("Discover"),
  YOUR_HIRES("Your hires"),
  COMPANY_HIRES("Company hires"),
  BYO_TALENT("BYO talent"),
  RECENTLY_VIEWED("Recently viewed"),
  SAVED_TALENT("Saved talent");

  private final String itemName;

  TalentItems(String itemName) {
    this.itemName = itemName;
  }

  public String getItemName() {
    return itemName;
  }
}
