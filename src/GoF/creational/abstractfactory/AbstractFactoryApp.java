package GoF.creational.abstractfactory;

public class AbstractFactoryApp {

	public static void main(String[] args) {
		MotherboardFactory factory = getFactoryByCountryCode("Intel");
		GeneralCPUparam cpu = factory.getCPU();
		GeneralRAMparam ram = factory.getRAM();
		Chipset chip = factory.getChipset();

		cpu.cacheSize(4);
		cpu.processorCapacity(64);
		ram.RAMSizes(2);
		chip.costOfChipset(20);
	}

	private static MotherboardFactory getFactoryByCountryCode(String lang) {
		switch (lang) {
		case "Intel":
			return new IntelDeviceFactory();
		case "AMD":
			return new AMDDeviceFactory();
		default:
			throw new RuntimeException("Unsupported : " + lang);
		}
	}
}

interface GeneralCPUparam {
	void clockSignal(int number);

	void cacheSize(int memoryPerCore);

	void processorCapacity(int bit);
}

interface GeneralRAMparam {
	void RAMSizes(int size);

	void RAMSpeed();
}

interface Chipset {
	void costOfChipset(int cent);
}

interface MotherboardFactory {
	GeneralCPUparam getCPU();

	GeneralRAMparam getRAM();

	Chipset getChipset();
}

class IntelCPU implements GeneralCPUparam {
	@Override
	public void clockSignal(int number) {
		System.out.println("(Intel) Number of clock signal per second = " + number);
	}

	@Override
	public void cacheSize(int MBPerCore) {
		System.out.println("(Intel) Cache size per core = " + MBPerCore);
	}

	@Override
	public void processorCapacity(int bit) {
		if (bit == 64) {
			System.out.println("(Intel) x64 ");
		} else if (bit == 32) {
			System.out.println("(Intel) x86 ");
		} else {
			System.out.println("(Intel) not found ");
		}
	}
}

class IntelRAM implements GeneralRAMparam {
	@Override
	public void RAMSizes(int size) {
		System.out.println("(Intel) Ram Size " + size);
	}

	@Override
	public void RAMSpeed() {
		System.out.println("(Intel) not so fast as CPU");
	}
}

class IntelChipset implements Chipset {
	@Override
	public void costOfChipset(int num) {
		System.out.println("(Intel) cost of chipset = " + num);
	}
}

class AMDCPU implements GeneralCPUparam {
	@Override
	public void clockSignal(int number) {
		System.out.println("(AMD) Number of clock signal per second = " + number);
	}

	@Override
	public void cacheSize(int MBPerCore) {
		System.out.println("(AMD) Cache size per core = " + MBPerCore);
	}

	@Override
	public void processorCapacity(int bit) {
		if (bit == 64) {
			System.out.println("(AMD) x64 ");
		} else if (bit == 32) {
			System.out.println("(AMD) x86 ");
		} else {
			System.out.println("(AMD) not found ");
		}
	}
}

class AMDRAM implements GeneralRAMparam {
	@Override
	public void RAMSizes(int size) {
		System.out.println("(AMD) Ram Size " + size);
	}

	@Override
	public void RAMSpeed() {
		System.out.println("(AMD) not so fast as CPU");
	}
}

class AMDChipset implements Chipset {
	@Override
	public void costOfChipset(int num) {
		System.out.println("(AMD) cost of chipset = " + num);
	}
}

class IntelDeviceFactory implements MotherboardFactory {
	@Override
	public GeneralCPUparam getCPU() {
		return new IntelCPU();
	}

	@Override
	public GeneralRAMparam getRAM() {
		return new IntelRAM();
	}

	@Override
	public Chipset getChipset() {
		return new IntelChipset();
	}
}

class AMDDeviceFactory implements MotherboardFactory {
	@Override
	public GeneralCPUparam getCPU() {
		return new AMDCPU();
	}

	@Override
	public GeneralRAMparam getRAM() {
		return new AMDRAM();
	}

	@Override
	public Chipset getChipset() {
		return new AMDChipset();
	}
}
