package org.indietxt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.powermock.reflect.Whitebox;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StockManagerServiceLocator.class})
public class ServiceLocatorTest {

	@Test
	public void getStockManager() {
		//Mock
		StockManager stockManagerImpl = mock(StockManager.class);
		StockManagerServiceLocator serviceLocator = mock(StockManagerServiceLocator.class);
		Whitebox.setInternalState(StockManagerServiceLocator.class, "INSTANCE", serviceLocator);

		//Stubbing
		when(serviceLocator.getStockManagerReference()).thenReturn(stockManagerImpl);

		//Invoke
		StockManagerServiceLocator.INSTANCE.getStockManagerReference();

		//Verify
		verify(serviceLocator, times(1)).getStockManagerReference();

	}

}
