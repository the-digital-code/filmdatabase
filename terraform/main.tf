terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~> 3.0"
    }
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  location = var.location
}

module "vm" {
  source              = "./modules/vm"
  location            = var.location
  resource_group_name = azurerm_resource_group.rg.name
  vm_name             = var.vm_name
}
